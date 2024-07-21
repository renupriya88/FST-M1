from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()
actions = webdriver.ActionChains(driver)

driver.get("https://v1.training-support.net/selenium/popups")
print(driver.title)

x = driver.find_element(By.CLASS_NAME, "orange")
# Move the cursor over the button to show tooltip
actions.move_to_element(x).perform()

print(x.get_attribute("data-tooltip"))

x.click()

username = driver.find_element(By.XPATH, '//*[@id="username"]')
password = driver.find_element(By.XPATH, '//*[@id="password"]')
    # Enter credentials
username.send_keys("admin")
password.send_keys("password")
    # Click login
driver.find_element(By.XPATH, "/html/body/div[4]/div/div[2]/div/div/button").click()

message = driver.find_element(By.ID, "action-confirmation")
print("Confirmation message: ", message.text)

driver.close