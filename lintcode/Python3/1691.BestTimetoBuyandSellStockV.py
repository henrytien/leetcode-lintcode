# https://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-v/description?_from=contest&&fromId=77

class Solution:
    """
    @param a: the array a
    @return: return the maximum profit
    """
    def getAns(self, a):
        # write your code here
        import heapq as hq
        h = []
        hold = []
        money = 0
        
        for item in a:
            if not h:
                hq.heappush(h,item)
            elif h[0] < item:
                money -= h[0]
                if h[0] in hold:
                    hold.remove(h[0])
                else:
                    hq.heappop(h)
            
                money += item;
                
                hold.append(item)
                hq.heappush(h,item)
            else:
                hq.heappush(h,item)
        return money
                