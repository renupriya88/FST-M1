from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/dynamic-controls")
print(driver.title)

togglebox = driver.find_element(By.ID, "toggleCheckbox")
checkbox = driver.find_element(By.ID, "dynamicCheckbox")

togglebox.click()
wait.until(EC.invisibility_of_element(checkbox))
print(f"check box is not visible {checkbox.text}")

togglebox.click()
wait.until(EC.visibility_of(checkbox))
print(checkbox.text)

checkbox.click()

driver.quit()

