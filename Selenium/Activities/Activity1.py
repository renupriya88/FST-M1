from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

#Open a new browser to https://v1.training-support.net.
    driver.get("https://v1.training-support.net")

#Get the title of the page and print it to the console.
    print(f"The title of the page is {driver.title}")

#Find the "About Us" button on the page using it's id.
    element = driver.find_element(By.ID, "about-link")

#Click on that button.
    element.click()

#Get the title of the new page and print it to the console.
    print(f"The title of the NEW page is {driver.title}")

#Close selenium sessions
    driver.quit
