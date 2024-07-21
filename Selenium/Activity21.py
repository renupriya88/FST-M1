from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 20)

driver.get("https://v1.training-support.net/selenium/tab-opener")
print("1st Window Title is " + driver.title)

driver.find_element(By.ID, "launcher").click()

wait.until(EC.new_window_is_opened)

print(f'Name of handles are below : {driver.window_handles}')

for i in driver.window_handles:
    driver.switch_to.window(i)

wait.until(EC.element_to_be_clickable(driver.find_element(By.ID, "actionButton")))
print("2nd Window Title is " + driver.title)
print(driver.find_element(By.CLASS_NAME, "content").text)

driver.find_element(By.ID, "actionButton").click()
wait.until(EC.new_window_is_opened)

for i in driver.window_handles:
    driver.switch_to.window(i)

wait.until(EC.title_is("Newtab2"))
print("3rd Window Title is " + driver.title)
print(driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div/div").text)


driver.close
