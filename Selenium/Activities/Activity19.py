from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.common.alert import Alert
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 100)

driver.get("https://v1.training-support.net/selenium/javascript-alerts")
print(driver.title)

	
# Click the link to activate the alert
driver.find_element(By.XPATH, '//*[@id="confirm"]').click()

	
# Wait for the alert to be displayed and store it in a variable
alert = wait.until(EC.alert_is_present())
print(alert)

# Store the alert text in a variable
print("Alert text is : " + alert.text)

alert.accept()

driver.find_element(By.XPATH, '//*[@id="confirm"]').click()
alert1 = wait.until(EC.alert_is_present())
print(alert1)
print("Alert1 text is : " + alert1.text)
alert1.dismiss()

driver.close