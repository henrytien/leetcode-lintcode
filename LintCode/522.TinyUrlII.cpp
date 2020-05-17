// https://www.lintcode.com/problem/tiny-url-ii/description
/* 
 * Two map store long2short, short2long, and cnt store the short
 * url count, 注意计算short_key
 */
class TinyUrl2
{
public:
    TinyUrl2() : cnt(0) {}
    /*
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    string createCustom(string &long_url, string &key)
    {
        string short_url = TINYURL + key;
        if (long2short.find(long_url) != long2short.end())
        {
            if (long2short[long_url] == short_url)
            {
                return short_url;
            }
            else
            {
                return "error";
            }
        }

        if (short2long.find(short_url) != short2long.end())
        {
            return "error";
        }

        long2short[long_url] = short_url;
        short2long[short_url] = long_url;
        return short_url;
    }

    /*
     * @param long_url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    string longToShort(string &long_url)
    {
        if (long2short.find(long_url) != long2short.end())
        {
            return long2short[long_url];
        }

        string short_key = new_short_url();
        long2short[long_url] = short_key;
        short2long[short_key] = long_url;
        return short_key;
    }

    /*
     * @param short_url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    string shortToLong(string &short_url)
    {
        if (short2long.find(short_url) != short2long.end())
        {
            return short2long[short_url];
        }
        else
        {
            return "error";
        }
    }

public:
    int cnt;
    map<string, string> long2short;
    map<string, string> short2long;
    const string TINYURL = "http://tiny.url/";

    string new_short_url()
    {
        string short_key;
        char c[] = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
        for (int i = 0, j = cnt; i < 6; ++i)
        {
            short_key += c[j % 62];
            j /= 62;
        }
        ++cnt;
        return TINYURL + short_key;
    }
};