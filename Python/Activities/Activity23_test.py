import pytest

@pytest.fixture
def test_containingnumber():
    list1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    return list1

def test_sumof_list(test_containingnumber_s):
    sum = 0
    
    for index in test_containingnumber_s:
        sum = sum + index
    
    assert sum == 55


