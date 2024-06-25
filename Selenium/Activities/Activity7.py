from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
actions = webdriver.ActionChains(driver)

driver.get("https://v1.training-support.net/selenium/drag-drop")
print(driver.title)

element = driver.find_element(By.ID, "draggable")
element1 = driver.find_element(By.ID, "droppable")
element2 = driver.find_element(By.ID, "dropzone2")

actions.click(element).drag_and_drop(element, element1).perform()
print(element1.text)
if element1.text.find("Dropped"):
    print("ball dropped in dropzone1")

    actions.click(element).drag_and_drop(element1, element2).perform()
    print(element2.text)
    if element2.text.find("Dropped"):
        print("ball dropped in dropzone2")
else:
    print("check why ball was not dropped in dropzone1")

driver.quit() 
