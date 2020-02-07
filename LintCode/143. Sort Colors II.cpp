// https://www.lintcode.com/problem/sort-colors-ii/description?_from=ladder&&fromId=1

// three pointer 
class Solution {
public:
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    void sortColors2(vector<int> &colors, int k) {
        int size = colors.size();
        
        if(size == 0 || k == 0){
            return;
        }
        
        int start = 0, end = colors.size() - 1;
        int min = 0, max = k;
        while(min < max)
        {
            
            int index = start;
            while(index <= end){
                if(colors[index] == min){
                    swap(colors[index],colors[start]);
                    index++;
                    start++;
                }
                else if(colors[index] > min && colors[index] < max){
                    index++;
                }
                else{
                    swap(colors[end],colors[index]);
                    end--;
                }
            }
            min++;
            max --;
        }
        
    }
};


// Divide && Conquer
class Solution {
public:
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    void sortColors2(vector<int> &colors, int k) {
        colorSort(colors,0,colors.size()-1,1,k);
    }
    
    void colorSort(vector<int> &colors,int start, int end, int low, int high)
    {
        if(start >= end || low >= high){
            return;
        }
        
        int mid = low + (high - low) / 2;
        int left = start, right = end;
        while(left <= right){
            while(left <= right && colors[left] <= mid){
                left++;
            }
            
            while(left <= right && colors[right] > mid){
                right--;
            }
            
            if(left <= right){
                swap(colors[left++],colors[right--]);
            }
        }
        
        colorSort(colors,start,right, low,mid);
        colorSort(colors,left,end,mid + 1,high);
    }
};


    // unordered_map O(n)

    class Solution {
public:
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    void sortColors2(vector<int> &colors, int k) {
        
        unordered_map<int,int> myHash;
        std::map<int, int> map;
        for (auto &e : colors) {
            myHash[e]++;
            map[e]++;
        }
       
        int j = 1;
        for (int i = 0; i < colors.size(); i++) {
            if(myHash[j] > 0){
                colors[i] = j;
                myHash[j] --;
            }
            if(myHash[j] == 0){
                j++;
            }
        }
    }
};
