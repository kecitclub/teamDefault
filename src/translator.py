from googletrans import Translator

# Initialize the translator
translator = Translator()

def translate_to_nepali(english_text):
    """
    Translates the given English text into Nepali (Devanagari script).

    Parameters:
    - english_text (str): The English text to be translated.

    Returns:
    - str: The translated text in Nepali.
    """
    # Translate to Nepali
    translation = translator.translate(english_text, src='en', dest='ne')

    # Return the translated text
    return translation.text

english_text = "Flying Kites: During Dashain, children like you fly kites to tell the gods that the rainy season is over and the skies are clear again.Tika and Jamara: Elders put red tika on the foreheads of younger family members and bless them for a happy and successful life. The tika is like a magical mark of protection and love. Along with it, they place green jamara (barley grass), which symbolizes prosperity.Swinging on Bamboo Swings: Villages and towns build big bamboo swings called ping. Children swing high into the sky, laughing and feeling free, as a way to say thank you to the gods.easting: Delicious food like rice, meat curries, and sweets are cooked. Families gather around to share meals, tell stories, and have fun.Worshipping the Goddess Durga: Beautiful statues of Goddess Durga are made, and people offer flowers, fruits, and prayers to thank her for protecting the world from evil."
nepali_text = translate_to_nepali(english_text)
print("Translated text:", nepali_text)
