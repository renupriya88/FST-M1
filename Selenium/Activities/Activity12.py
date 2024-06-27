from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
wait = WebDriverWait(driver, 20)

driver.get("https://v1.training-support.net/selenium/dynamic-controls")
print(driver.title)

Bool = driver.find_element(By.XPATH, '//*[@id="input-text"]').is_enabled()
print(Bool)

driver.find_element(By.XPATH, '//*[@id="toggleInput"]').click()

print(driver.find_element(By.XPATH, '//*[@id="input-text"]').is_enabled())

driver.quit()
