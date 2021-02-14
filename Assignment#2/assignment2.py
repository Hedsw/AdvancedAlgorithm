import random

def main():
    time, time = 0, 0
    n = 5    
    finalarrivetime = [0] * n
    biking = [0] * n 
    swimming = [0] * n
    riding = [0] * n

    for i in range(n):
        swimming[i] = random.randint(0, 10) + 1
        biking[i] = random.randint(0, 10) + 1
        riding[i] = random.randint(0, 10) + 1
    '''
    print(swimming)
    print("Swimming")
    print(biking)
    print("biking")
    print(riding)
    print("riding")
    print('------------')
    '''

    for i in range(n-1):
        j = i+1
        for j in range(n):
            if(biking[i] + riding[i] < biking[j] + riding[j]):
                temp = swimming[i]
                swimming[i] = swimming[j]
                swimming[j] = temp

                temp = biking[i]
                biking[i] = biking[j]
                biking[j] = temp

                temp = riding[i]
                riding[i] = riding[j]
                riding[j] = temp

    for i in range(n):
        print("Participant No." , i + 1, " Swimming Time = ", swimming[i] , "Biking Time = " , biking[i] , "Riding Time = " , riding[i])

    for i in range(n):
        time = time + swimming[i]
        if len(finalarrivetime) > i:
            finalarrivetime[i] = finalarrivetime[i] + time
        else:
            finalarrivetime[i] = time
    
    for i in range(n):
        if biking[i] + riding[i] <= time - finalarrivetime[i]:
            continue
        else:
            time = time + (biking[i] + riding[i]) - (time - finalarrivetime[i])

    print("Total Time " , n , "Participant is... " , time , "minute")
