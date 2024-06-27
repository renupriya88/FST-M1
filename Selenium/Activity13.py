from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
driver.get("https://v1.training-support.net/selenium/tables")
print(driver.title)

rows = driver.find_elements(By.XPATH, "/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr")
print(len(rows))

columns = driver.find_elements(By.XPATH, "/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td")
print(len(columns))


third_row = driver.find_elements(By.XPATH, "/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr[3]/td")
for i in third_row:
    print(i.text)
    
second_row_column = driver.find_element(By.XPATH, "/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]")
print(second_row_column.text)

driver.quit()