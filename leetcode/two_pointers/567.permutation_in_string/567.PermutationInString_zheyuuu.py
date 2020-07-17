class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        def equal(a, b):
            for k,v in a.items():
                if not(k in b and b[k]==a[k]):
                    return False
            return True
        
        a = collections.Counter(s1)
        n = len(s1)
        m = len(s2)
                    
        b = collections.Counter(s2[:n])
        if equal(a,b):
            return True
        for i in range(1,m-n+1):
            remove = s2[i-1]
            add = s2[i+n-1]
            b[remove] -= 1
            if add not in b:
                b[add] = 0
            b[add] += 1
            if equal(a,b):
                return True
        return False