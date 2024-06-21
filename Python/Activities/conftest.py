import pytest

@pytest.fixture
def input_value():
   input = 6
   return input

@pytest.fixture
def test_containingnumber_s():
    list1 = (range(11))
    return list1