from gtts import gTTS
from pydub import AudioSegment
import os

def devanagari_to_speech(text, lang='ne', output_file='output.mp3', speed_factor=1.2, pitch_shift=4):
    try:
        # Convert text to speech using gTTS
        tts = gTTS(text, lang=lang)
        temp_file = 'temp_output.mp3'
        tts.save(temp_file)

# Adjust speed and pitch using pydub
        sound = AudioSegment.from_mp3(temp_file)

        # Adjust the speed of the speech (makes it faster or slower)
        sound = sound.speedup(playback_speed=speed_factor)

        # Change pitch by shifting it
        sound = sound._spawn(sound.raw_data, overrides={
            "frame_rate": int(sound.frame_rate * (2 ** (pitch_shift / 12.0)))
        })

        # Save the modified audio to the output file
        sound.export(output_file, format="mp3")

        # Clean up temporary file
        os.remove(temp_file)

        print(f"Speech saved to {output_file}")
        return True

    except Exception as e:
        print(f"Error: {e}")
        return False
