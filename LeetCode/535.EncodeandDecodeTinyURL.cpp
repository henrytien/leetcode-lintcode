// https://leetcode.com/problems/encode-and-decode-tinyurl/
/* 
 * Map
 * Base62
 */

class Solution
{
public:
    // Encodes a URL to a shortened URL.
    string encode(string longUrl)
    {
        long long ans = 0;
        for (int i = 0; i < longUrl.size(); i++)
        {
            ans = (ans * 256L + (long long)longUrl[i]) / 50000000L;
        }
        long long id = ans % 50000000L;

        while (mp_.find(id) != mp_.end() && mp_[id] != longUrl)
        {
            id++;
        }

        mp_[id] = longUrl;

        return TINYURL + id_to_short_key(id);
    }

    // Decodes a shortened URL to its original URL.
    string decode(string shortUrl)
    {
        string short_key = get_short_key(shortUrl);
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

        for (int i = 0; i < short_key.size(); i++)
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

    string id_to_short_key(long long n)
    {
        string short_key;
        char c[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWZYZ123456789";
        while (n)
        {
            short_key.push_back(c[n % 62]);
            n /= 62;
        }

        while (short_key.size() < 6)
        {
            short_key.push_back('a');
        }
        return short_key;
    }

private:
    map<long long, string> mp_;
    const string TINYURL = "http://tinyurl.com/";
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));