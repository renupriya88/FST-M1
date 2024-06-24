from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
actions = webdriver.ActionChains(driver)

driver.get("https://v1.training-support.net/selenium/input-events")

print(driver.title)

actions.click().perform
print(driver.find_element(By.CLASS_NAME, "active").text)

actions.double_click().perform
print(driver.find_element(By.CLASS_NAME, "active").text)

actions.context_click().perform
print(driver.find_element(By.CLASS_NAME, "active").text)

driver.quit()