def solution(friends, gifts):
    friends_num = len(friends)
    matrix = [[0] * friends_num for _ in range(friends_num)]
    print(matrix)
    arrs = []
    for gift in gifts:
      gift_f, gift_t = gift.split()
      arrs.append([gift_f, gift_t])

    #표
    for i in range(0, friends_num):
      for arr in arrs:
        if(friends[i] == arr[0]):
          for k in range(0, friends_num):
            if(friends[k] == arr[1]):
              matrix[i][k] +=1

    #표 선물지수구하기 전
    matrix2 = [[0] *2 for _ in range(friends_num)]

    for i in range(0, friends_num):
      for j in range(0, friends_num):
        matrix2[i][0] += matrix[i][j]
        matrix2[i][1] += matrix[j][i]

    matrix3 = [[0] for _ in range(friends_num)]


    #표 선물지수구하기 후
    for i in range(0, friends_num):
        matrix3[i] = matrix2[i][0]-matrix2[i][1]

    matrix4 = [0 for _ in range(friends_num)]
    for i in range(0, friends_num):
        for j in range(0, friends_num):
          if(i != j) :
              #matrix[i][j] : i가 j에게 준 선물 수
              #matrix[j][i] : j가 i에게 준 선물 수
              if(matrix[i][j] > matrix[j][i]):
                matrix4[i] += 1
              elif(matrix[i][j] == matrix[j][i]) :
                if(matrix3[i] > matrix3[j]):
                  matrix4[i] += 1


    answer = max(matrix4)
    return answer

