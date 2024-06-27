from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
wait = WebDriverWait(driver, 20)

driver.get("https://v1.training-support.net/selenium/dynamic-controls")
print(driver.title)

Bool = driver.find_element(By.XPATH, '//*[@id="dynamicCheckbox"]/label').is_selected()
print(Bool)

element = driver.find_element(By.XPATH, '/html/body/div[3]/div/div[1]/div[1]/input')
element.click()

print(element.is_selected())

driver.quit()
