### 

## Easy
- 2019年2月7日  
[342. Power of Four](https://leetcode.com/problems/power-of-four/)
    > The(num - 1) % 3 == 0is used to distinguish the 4^n from 2^n.
2^n = (3-1)^n = C(n,0)3^n(-1)^0+....+(-1)^n. 
  1. When 2^n is 4^n, which means n is even, in this case, (-1)^n==1 and (2^n-1）%3==0 
  2. When 2&n is not 4^n, which means n is odd, in this case, (-1)^n=-1 and (2^n-1）%3==1；


- 2019年2月5日  
[771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)