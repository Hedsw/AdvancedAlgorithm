# Implement the proposal-and-reject algorithm in Chapter 1, page 6, 
# using the programming language you choose and the efficient implementation techniques 
#  described on Lecture notes (Slide 23, 24 on page 11).
#  import requests


menPrefRecord = [['Bertha','Amy','Diane','Erika','Clare'],
    ['Diane','Bertha','Amy','Clare','Erika'],
    ['Bertha','Erika','Clare','Diane','Amy'],
    ['Amy','Diane','Clare','Bertha','Erika'],
    ['Bertha','Diane','Amy','Erika','Clare']]

womenPrefRecord = [['Zeus','Victor','Wyatt','Yancey','Xavier'],
    ['Xavier','Wyatt','Yancey','Victor','Zeus'],
    ['Wyatt','Xavier','Yancey','Zeus','Victor'],
    ['Victor','Zeus','Yancey','Xavier','Wyatt'],
    ['Yancey','Wyatt','Zeus','Xavier','Victor']]

m = ['Victor', 'Wyatt', 'Xavier', 'Yancey', 'Zeus']
w = ['Amy', 'Bertha', 'Clare', 'Diane', 'Erika']

def ProposeReject():
    #print("HelloWorld")
    N = len(menPrefRecord)
    CountingStopby = 0
    menPreference = menPrefRecord
    womenPreference = womenPrefRecord
    EngageW = ['X'] * N
    womenMatchPartner = ['X'] * N
    menMartner = ['X'] * N 

    Matches(CountingStopby, N, EngageW, menPreference, menMartner, womenPreference)
    
def Matches(CountingStopby, N, EngageW, menPreference, menPartner, womenPreference):
    while CountingStopby < N:
        for free in range(N):
            if EngageW[free] == 'X':
                break
        i = 0
        while i < N and EngageW[free] == 'X':
            index = menIndexChange(womenPreference[free][i], N)
            if menPartner[index] == 'X':
                menPartner[index] = w[free]
                EngageW[free] = True
                CountingStopby = CountingStopby + 1
                            
            else:
                currentPartner = menPartner[index]
                if Preference(currentPartner, w[free], index, N, menPreference):
                    menPartner[index] = w[free]
                    EngageW[free] = True
                    EngageW[womenIndexChange(currentPartner, N)] = 'X'
                    #print(womenPartner, "Women22")
            i = i + 1
    #print("End of Loop")
    PrintMatched(menPreference, womenPreference, menPartner)

            
def Preference(curPartner, newPartner, index, N, menPreference):
    for i in range(N):
        if menPreference[index][i] == newPartner:
            #print(wprefer[index][i], ' Preference if1')
            return True
        if menPreference[index][i] == curPartner:
            #print(wprefer[index][i], ' Preference if2')
            return False
    return False

def menIndexChange(str, N):
    for i in range(N):
        if m[i] == str:
            return i
    print('Him??')
    return 0

def womenIndexChange(str, N):
    for i in range(N):
        if w[i] == str:
            return i
    print('Her?')
    return 0


def PrintMatched(menMatch, womenMatch, menMatchMartner):
    i = 0 
    j = 0
    print(' ')
    print(' ')
    print("Yunhyeok Lee First Assignment")
    print(' ')
    print("Men Preference List")

    for i in range(5):
        print(m[i], '-> ',end=' ')
        for j in range(5):
            print(menPrefRecord[i][j], end=' ')
        print(' ')
    print(' ')    
    print("Women Preference List")
    for i in range(5):
        print(w[i], '-> ',end=' ')
        for j in range(5):
            print(womenPrefRecord[i][j], end=' ')
        print(' ')
    print(' ')
    print("Final Matching Result is..")
    for i in range(5):
        print(menMatchMartner[i], ' ', m[i])
