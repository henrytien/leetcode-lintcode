// https://www.lintcode.com/problem/tiny-url/description
// 使用一个map 存ID到长链接
// longToShort 计算出一个ID，这个ID去使用Base62 不断的除，计算出short_key
// shortToLong 取出short_key，使用Base62 对字符和数字不断乘以62，计算出ID，
// 最后取出map_[id]所对应的url, 特别注意对Base62中间结果计算。
const string TINYURL = "http://tiny.url/";

class TinyUrl
{
public:
    /*
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    string longToShort(string &url)
    {
        if (url.size() == 0)
        {
            return "";
        }
        long long ans = 0;
        for (int i = 0; i < url.size(); i++)
        {
            ans = (256L * ans + (long long)url[i]) % 56800235584L;
        }

        long long id = ans % 56800235584L;
        while (mp_.find(ans) != mp_.end() && mp_[id] != url)
            id++;

        mp_[id] = url;
        string short_key = id_to_short_key(id);
        return TINYURL + short_key;
    }

    /*
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    string shortToLong(string &url)
    {
        string short_key = get_short_key(url);
        long long id = short_key_to_id(short_key);
        return mp_[id];
    }

private:
    string get_short_key(string &url)
    {
        return url.substr(TINYURL.size(), url.size() - TINYURL.size());
    }

    long long short_key_to_id(string &short_key)
    {
        long long id = 0;
        for (int i = 0; short_key[i] && i < 6; i++)
        {
            if ('a' <= short_key[i] && short_key[i] <= 'z')
            {
                id = id * 62 + short_key[i] - 'a';
            }
            if ('A' <= short_key[i] && short_key[i] <= 'Z')
            {
                id = id * 62 + short_key[i] - 'A' + 26;
            }

            if ('0' <= short_key[i] && short_key[i] <= '9')
            {
                id = id * 62 + short_key[i] - '0' + 52;
            }
        }

        return id;
    }

    string id_to_short_key(long long &n)
    {
        string short_key;
        char a[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        while (n)
        {
            short_key.push_back(a[n % 62]);
            n = n / 62;
        }

        while (short_key.size() < 6)
        {
            short_key.push_back('a');
        }

        reverse(short_key.begin(), short_key.end());
        return short_key;
    }

private:
    map<long long, string> mp_;
};