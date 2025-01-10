from gtts import gTTS
import os

def devanagari_to_speech(text, lang='ne', output_file='output.mp3'):
    try:
        # Convert text to speech
        tts = gTTS(text, lang=lang)
        tts.save(output_file)
        print(f"Speech saved to {output_file}")

        # Play the audio (optional)
        os.system(f"start {output_file}" if os.name == 'nt' else f"open {output_file}")

    except Exception as e:
        print(f"Error: {e}")

# Example Nepali text in Devanagari script
# nepali_text = "नमस्ते, तपाईंलाई कस्तो छ?"
# devanagari_to_speech(nepali_text)
