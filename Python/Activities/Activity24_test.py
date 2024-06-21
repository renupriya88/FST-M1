import pytest

@pytest.fixture
def wallet():
    amount = 0
    return amount

@pytest.mark.parametrize("earned, spent, expected",[(30, 10,20), (20, 2, 18)])
def test_activity24(wallet, earned, spent, expected):
#I add {earned} units of cash to the wallet
    wallet = wallet + earned
    assert wallet - spent == expected