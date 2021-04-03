Initially, Pseudo Code is..

Initially, x1..xi, r1...ri distance, milesRestriction


maxRev(int billboardValue, int rev, int distance, int milesRestriction)
    for i = 1 to distance:
        if nextBillboardValue < maxbillboardLength:
            if billboard[nextBillboardValue] != i:
                milesRes[i] = milesRes[i-1]
            else:
                if i >= milesRestriction:
                    milesRes[i] = max(milesRes[i - milesRestriction] + rev[nextBillboardValue], milesRes[i-1])
                    // OPT(j) = max(rj + OPT(e(j)), OPT(j-1))
                else:
                    milesRes[i] = rev[nextBillboardValue] 
                endif
            nextBillboardValue++
        else:
            milesRes[i] = milesRes[i - 1]
        endif
    Endfor

    return milesRes[distance]

-----------------------------------------------------------------------------------------------------------------------

For example,
{x1, ..., x10} = {6, 7, 11, 12, 13, 14, 16, 21, 26, 30}
{r1, ..., r10} = {5, 6, 5, 2, 1, 3, 2, 4, 1, 1}


distance = 50 
milesRestriction = 5

output: 15 ( 5 + 5 + 4 + 1 )

Time Complexity: O(n) 




OPT(L,H, length)
    for(i to length)
        listsL[i] = max(L[i] + listL[i-1], L[i] + list[i-1])
        listsH[i] = max(H[i] + listsL[i-2], H[i] + listsH[i-2])
    Endfor

print(max(listsH[length], listsL[length]))
