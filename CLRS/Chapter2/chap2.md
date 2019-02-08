
2.2-2  
```
selection sort
    n = A.length;
    for j = 1 to n -1
      smallest = j
      for i = j + 1 to n
         if A[i] < A[smallest]
            smallest = j
        exchange A[j] with A[smallest]

```
2.3-2
> Rewrite the \text{MERGE}MERGE procedure so that it does not use sentinels, instead stopping once either array LL or RR has had all its elements copied back to AA and then copying the remainder of the other array back into AA.
```
Merger(A,p,q,r)
    n1 = q - p + 1
    n2 = r - q
    let L[1..n1 + 1] and R[1..n2 + 1] be new arrays

    for i = 1 to n1
        L[i] = A[p + i -1]
    for j = 1 to n2
        R[j] = A[q + j] 
    i = 1
    j = 1
    for k = p to r
        if i > n[1]
            A[k] = R[j]
            j = j + 1
        else if j > n[2]
            A[k] = L[i]
            i = i + 1
        else 
            A[K] = R[j]
            j = j + 1 
```

