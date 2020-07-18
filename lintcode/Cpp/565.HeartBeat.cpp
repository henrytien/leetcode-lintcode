// https://www.lintcode.com/problem/heart-beat/description
class HeartBeat
{
public:
    HeartBeat()
    {
        // do intialization if necessary
        k = 0;
        slaves_ip_list.clear();
    }

    /*
     * @param slaves_ip_list: a list of slaves'ip addresses
     * @param k: An integer
     * @return: nothing
     */
    void initialize(vector<string> &slaves_ip_list, int k)
    {
        // write your code here
        this->k = k;
        for (auto ip : slaves_ip_list)
        {
            this->slaves_ip_list[ip] = 0;
        }
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @param slave_ip: the ip address of the slave server
     * @return: nothing
     */
    void ping(int timestamp, string &slave_ip)
    {
        // write your code here
        if (slaves_ip_list.find(slave_ip) == slaves_ip_list.end())
            return;

        slaves_ip_list[slave_ip] = timestamp;
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @return: a list of slaves'ip addresses that died
     */
    vector<string> getDiedSlaves(int timestamp)
    {
        // write your code here
        vector<string> result;
        for (map<string, int>::iterator iter = slaves_ip_list.begin();
             iter != slaves_ip_list.end(); ++iter)
        {
            int time = iter->second;
            if (time <= timestamp - 2 * k)
            {
                result.push_back(iter->first);
            }
        }
        return result;
    }

private:
    int k;
    map<string, int> slaves_ip_list;
};