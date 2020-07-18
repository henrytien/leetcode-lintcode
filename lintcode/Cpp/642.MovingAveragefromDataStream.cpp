// https://www.lintcode.com/problem/moving-average-from-data-stream/description?_from=ladder&&fromId=1
class MovingAverage {
public:
    /*
    * @param size: An integer
    */MovingAverage(int size) {
        this->size = size;
        this->sum = 0;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    double next(int val) {
        // write your code here
        sum += val;
        if(q.size() == size){
            sum -= q.front();
            q.pop();
        }
        q.push(val);
        return sum / q.size();
    }
private:
    double sum;
    int size;
    std::queue<int> q;
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 */