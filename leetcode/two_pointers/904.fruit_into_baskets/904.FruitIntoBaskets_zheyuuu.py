class Solution:
    def totalFruit(self, tree: List[int]) -> int:
        if not tree:
            return 0
        first = [tree[0],1]
        second = None
        i = 1
        ans = 1
        continuous_interval_start = 0
        # print("0:", first, second)
        while(i<len(tree)):
            now = tree[i]
            if now != first[0] and not second:
                second = [now, 1]
                continuous_interval_start = i
            else:
                if now==first[0]:
                    first[1] += 1
                    if tree[continuous_interval_start]!=now:
                        continuous_interval_start = i
                elif now == second[0]:
                    second[1] += 1
                    if tree[continuous_interval_start]!=now:
                        continuous_interval_start = i
                else:
                    first = [tree[continuous_interval_start], i-continuous_interval_start]
                    second = [now, 1]
                    continuous_interval_start = i
            # print(i,":",first, second, continuous_interval_start)
            if not second:
                ans = max(first[1], ans)
            else:
                ans = max(first[1]+second[1], ans)
            i += 1
        
        return ans
    
    def totalFruit(self, tree: List[int]) -> int:
        # Core: b        ->  end of current string
        #       count_b  ->  The length of longest string with all b
        ans = cur = count_b = a = b = 0
        
        for c in tree:
            if c in (a,b):
                cur +=1
            else:
                cur = count_b+1
            if b==c:
                # b is still the last element.
                count_b +=1
            else:
                count_b = 1
                # now a is end, exchange.
                a = b
                b = c
            ans = max(cur, ans)
        return ans