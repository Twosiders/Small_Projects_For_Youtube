#Pinterest Board (Album) Downloader - by Alex Mezodi

'''
Usage:
1. Run the Pinterest_Board_Downloader_Application in Python 3.0 or later.
2. Input the Pinterest board's full URL and press enter.
3. The images will be saved at the highest available resolution
into the folder "PinterestUsername_BoardName" inside the
"Pinterest_Board_Downloader" folder. 

Technical explanation:
- We use the BeautifulSoup Python library to go to the Input URL
- Find the DIV with the specific class, which contains all the images
- Open all the individual image DIVs using a For Loop
- Go all the way down to the DIV which contains an ahref URL link
which in turn goes to the individual image's page.

- Find the individual image's DIV which has a special class.
- Save the image's source URL to the string newImgTab
- Change this URL using Regular Expressions, so instead of a
low resolution image, we get the highest resolution.
- Save the image(s) into a folder which has the Pinterest
user's name and board name from the input URL.
'''

from bs4 import BeautifulSoup
