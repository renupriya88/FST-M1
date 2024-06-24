from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:

    driver.get("https://v1.training-support.net/selenium/login-form")

    print(f"Title of the page is {driver.title}")

    driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")
    driver.find_element(By.XPATH, "//input[@id='password']").send_keys("password")
    driver.find_element(By.XPATH, "//button[@onclick='signIn()']").click()
    

    print(f"Title of new page is {driver.find_element(By.XPATH, "//div[@id ='action-confirmation']").text}")

    driver.quit()

