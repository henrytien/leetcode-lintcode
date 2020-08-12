// https://www.lintcode.com/problem/word-count-map-reduce/description
/**
 * Definition of Input:
 * template<class T>
 * class Input {
 * public:
 *     bool done(); 
 *         // Returns true if the iteration has elements or false.
 *     void next();
 *         // Move to the next element in the iteration
 *         // Runtime error if the iteration has no more elements
 *     T value();
 *        // Get the current element, Runtime error if
 *        // the iteration has no more elements
 * }
 */

class WordCountMapper : public Mapper
{
public:
    void Map(Input<string> *input)
    {
        // Write your code here
        // Please directly use func 'output' to
        // output the results into output buffer.
        // void output(string &key, int value);
        while (!input->done())
        {
            vector<string> words = split(input->value(), " ");
            for (auto word : words)
            {
                output(word, 1);
            }
            input->next();
        }
    }

private:
    vector<string> split(const string &str, string delim)
    {

        int last_index = 0, index;
        vector<string> result;
        while ((index = str.find(delim, last_index)) != string::npos)
        {
            result.push_back(str.substr(last_index, index - last_index));
            last_index = index + delim.length();
        }
        // last one
        if (last_index <= str.length())
        {
            result.push_back(str.substr(last_index, str.length() - last_index));
        }
        return result;
    }
};

class WordCountReducer : public Reducer
{
public:
    void Reduce(string &key, Input<int> *input)
    {
        // Write your code here
        // Please directly use func 'output' to
        // output the results into output buffer.
        // void output(string &key, int value);
        int sum = 0;
        while (!input->done())
        {
            sum += input->value();
            input->next();
        }
        output(key, sum);
    }
};