//find the access codes
def solution(l)

    count = 0
    data = l
    max_element = max(data)
    tree_list = []
    
    for p,element in enumerate(data):
        
        if element == 0:
            tree_list.append([])
        
        else:
            temp = []
            for el in data[p+1:]:
                if el%element == 0:
                    temp.append(el)
            
            tree_list.append(temp)
    
    for p,element_list in enumerate(tree_list):
        data[p] = 0
        temp = data[:]
        for element in element_list:
            pos_element = temp.index(element)
            count += len(tree_list[pos_element])
            temp[pos_element] = 0
        
    return count
