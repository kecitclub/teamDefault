from flask import Flask, request, jsonify
from context_retrieve import get_context_from_query
from question_asnwer import generate_fun_qa_from_context
from translator import translate_to_nepali
from tts import devanagari_to_speech
import asyncio

app = Flask(__name__)

# Route for retrieving context based on a question
@app.route('/retrieve', methods=['POST'])
def retrieve_context():
    data = request.json
    query = data.get('query')
    document_path = data.get('document_path')

    if not query or not document_path:
        return jsonify({"error": "Query and document_path are required."}), 400

    try:
        context = get_context_from_query(query, document_path)
        return jsonify({"context": context})
    except Exception as e:
        return jsonify({"error": str(e)}), 500

# Route for generating QA based on a story
@app.route('/generate_qa', methods=['POST'])
def generate_qa():
    data = request.json
    context = data.get('context')

    if not context:
        return jsonify({"error": "Context is required."}), 400

    try:
        qa_output = generate_fun_qa_from_context(context)
        return jsonify({"qa": qa_output})
    except Exception as e:
        return jsonify({"error": str(e)}), 500

@app.route('/translate', methods=['POST'])
def translate():
    data = request.json
    english_text = data.get('text')

    if not english_text:
        return jsonify({"error": "Text to translate is required."}), 400

    try:
        # Call the synchronous translation function
        nepali_text = translate_to_nepali(english_text)
        return jsonify({"translated_text": nepali_text})
    except Exception as e:
        return jsonify({"error": str(e)}), 500

@app.route('/convert', methods=['POST'])
def convert_text_to_speech():
    data = request.get_json()

    if 'text' not in data:
        return jsonify({"error": "Missing 'text' field"}), 400

    text = data['text']
    output_file = 'output.mp3'

    result = devanagari_to_speech(text, output_file=output_file)

    if result:
        return jsonify({"message": f"Speech saved to {output_file}"}), 200
    else:
        return jsonify({"error": "Failed to convert text to speech"}), 500

if __name__ == '__main__':
    app.run(debug=True) 
