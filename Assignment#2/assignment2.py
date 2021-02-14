import random

def main():
    # Initializing 
    time, time = 0, 0
    n = 5    
    finalarrivetime = [0] * n
    biking = [0] * n 
    swimming = [0] * n
    riding = [0] * n


    # Initialize Swimming, Biking, Riding Time from 0 to 11 randomly.
    for i in range(n):
        swimming[i] = random.randint(1, 11) 
        biking[i] = random.randint(1, 11) 
        riding[i] = random.randint(1, 11)
    '''
    print(swimming)
    print("Swimming")
    print(biking)
    print("biking")
    print(riding)
    print("riding")
    print('------------')
    '''

    # Swapping if Biking + Riding time is bigger than previous bikinng and riding time, Convert the numbers
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

    # If the finalarrivetime length is bigger than i, finalArrivetTime = FinalArriveTime + Time
    # This is because to calculate all of numbers
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
