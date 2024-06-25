from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

driver = webdriver.Firefox()
actions = webdriver.ActionChains(driver)

driver.get("https://v1.training-support.net/selenium/input-events")

print(driver.title)

actions.key_down(Keys.SHIFT).send_keys("r").key_up(Keys.SHIFT).perform()
actions.key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(Keys.CONTROL).perform()

driver.quit()