from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


driver = webdriver.Firefox()
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/ajax")
print(driver.title)

driver.find_element(By.XPATH, '//*[@id="ajax-content"]/button').click()

element1 = driver.find_element(By.XPATH, '//*[@id="ajax-content"]/h1')
                     
wait.until(EC.visibility_of(element1))
print(element1.text)

wait.until(EC.text_to_be_present_in_element((By.XPATH, '//*[@id="ajax-content"]/h3'), "I'm late!"))
print(driver.find_element(By.XPATH, '//*[@id="ajax-content"]/h3').text)

driver.quit()

