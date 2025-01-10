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
    # Translate the text synchronously
    translation = translator.translate(english_text, src='en', dest='ne')

    # Return the translated text
    return translation.text

# Input text
english_text = "Flying Kites: During Dashain, children like you fly kites to tell the gods that the rainy season is over and the skies are clear again."

# Perform translation
nepali_text = translate_to_nepali(english_text)
print("Translated text:", nepali_text)
