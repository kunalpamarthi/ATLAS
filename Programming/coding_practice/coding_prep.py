def maxClothes(clo):
    oddSum, evenSum = 0, 0
    for i in range(0, len(clo)):
        if i%2:
            oddSum += clo[i]
        else:
            evenSum += clo[i]
    return oddSum if (oddSum>evenSum) else evenSum

def totalToys(coins, costs):
    costs.sort()
    totalCost = 0
    for i in range(0, len(costs)):
        if (costs[i]) > (coins-totalCost):
            return i
        else:
            totalCost += costs[i]
    return i+1

def candy(denom):
    box = []
    for i in denom:
        if i == 5:
            box.append(i)
        elif i == 10:
            if 5 in box:
                box.remove(5)
                box.append(i)
            else:
                return False
        elif i == 20:
            if(5 in box) and (10 in box):
                box.remove(5)
                box.remove(10)
                box.append(i)
            elif (box.count(5) >= 3):
                box.remove(5)
                box.remove(5)
                box.remove(5)
                box.append(i)
            else:
                return False
        else:
            return False
    return True

def pebbles(pebbles, size):
    if len(pebbles)%size:
        return False
    pebbles.sort()
    final = []
    for i in range(0,3):
       subGrp = []
       for i in pebbles:
           
           pass


input = []
# input = [5,5,10,10,20] # candy
# input = [1,6,3,1,2,5] # toys
# clothesFromHouses = [2,7,9,3,1]
# print(maxClothes(clothesFromHouses))
# print(totalToys(20, input))
# print(candy(input))
print(pebbles())