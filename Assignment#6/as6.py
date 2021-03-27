l = [7, 10, 10, 9]
h = [2, 50, 5, 5]
length = len(l)
listl = [0]*length
listh = [0]*length

listindex = 0

for i in range(1, length):
    if i < 2:
        listindex = i - 2 + length
    else:
        listindex = i - 2
    listl[i] = max(l[i] + listl[i-1], l[i] + listh[i-1])
    listh[i] = max(h[i] + listh[listindex], h[i] + listh[listindex])

print("Maximum Answer is ..", max(listl[length-1], listh[length-1]))

