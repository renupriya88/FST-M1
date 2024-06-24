from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()

driver.get("https://v1.training-support.net/selenium/target-practice")

print(driver.title)

print(driver.find_element(By.XPATH, "//h3[@id='third-header']").text)

print(driver.find_element(By.XPATH, "//h5[@class='ui green header']").value_of_css_property("color"))

print(driver.find_element(By.CLASS_NAME, "violet").get_attribute("class"))

print(driver.find_element(By.CLASS_NAME, "grey").text)

driver.quit()
