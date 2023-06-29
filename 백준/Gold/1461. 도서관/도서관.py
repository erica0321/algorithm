import sys

book, max = map(int, sys.stdin.readline().split())

book_place = sys.stdin.readline().split()
book_place = list(map(int, book_place))
place_length = len(book_place)

book_place.append(0)
book_place.sort()

home = book_place.index(0)
min_length = 0

#양수 배열 생성
#plus_place = []
plus_place = book_place[home+1: place_length+1]

#for i in range(home+1, place_length+1):
#    plus_place.append(book_place[i])

#음수 배열 생성
#minus_place = book_place[:home]
minus_place = [abs(x) for x in book_place[:home][::-1]]
#for i in range(home):
#    minus_place.append(abs(book_place[i7]))

#minus_place[::-1]                              #음수 배열값 정렬
min_size = len(minus_place)
plus_size = len(plus_place)

if(min_size == 0):
    minus_place.append(0)
if(plus_size == 0):
    plus_place.append(0)


if(minus_place[-1] > plus_place[-1]):
    min_length += minus_place[-1]               #거리가 가장 먼 값 더하기
    minus_place = minus_place[:-max]            #거리가 가장 먼 값 ~ 최대 책 수 제거
    min_size -= max
    #print(len(minus_place))
    while(min_size > max):                #남은 수가 최대 책 수 보다 작을 때 까지
        min_length += minus_place[-1] * 2
        minus_place = minus_place[:-max]
        min_size -= max
        #print(len(minus_place))
    if(min_size > 0):
        min_length += minus_place[-1] * 2

    while(plus_size > max):
        min_length += plus_place[-1] * 2
        plus_place = plus_place[:-max]
        plus_size -= max
        #print(len(plus_place))
    if(plus_size > 0):
        min_length += plus_place[-1] * 2

else:
    min_length += plus_place[-1]                #거리가 가장 먼 값 더하기
    plus_place = plus_place[:-max] #거리가 가장 먼 값 ~ 최대 책 수 제거
    plus_size -= max              
    #print(len(plus_place))
    while(plus_size > max):                 #남은 수가 최대 책 수 보다 작을 때 까지
        min_length += plus_place[-1] * 2
        plus_place = plus_place[:-max]
        plus_size -= max
        #print(len(plus_place))
    if(plus_size > 0):
        min_length += plus_place[-1] * 2

    while(min_size > max):
        min_length += minus_place[-1] * 2
        minus_place = minus_place[:-max]
        min_size -= max
        #print(len(minus_place))
    if(min_size > 0):
        min_length += minus_place[-1] * 2

print(min_length)