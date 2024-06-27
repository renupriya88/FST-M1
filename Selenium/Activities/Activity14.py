from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
driver.get("https://v1.training-support.net/selenium/tables")
print(driver.title)

rows = driver.find_elements(By.XPATH, '//*[@id="sortableTable"]/tbody/tr')
print(len(rows))

columns = driver.find_elements(By.XPATH, '//*[@id="sortableTable"]/thead/tr/th')
print(len(columns))

second_row_column = driver.find_element(By.XPATH, '//*[@id="sortableTable"]/tbody/tr[2]/td[2]')
print(second_row_column.text)

driver.find_element(By.XPATH, '//*[@id="sortableTable"]/thead/tr[1]/th[1]').click()

second_row_column = driver.find_element(By.XPATH, '//*[@id="sortableTable"]/tbody/tr[2]/td[2]')
print(second_row_column.text)

footer = driver.find_elements(By.XPATH, '//*[@id="sortableTable"]/tfoot/tr/th')
for i in footer:
    print(i.text)

driver.quit()