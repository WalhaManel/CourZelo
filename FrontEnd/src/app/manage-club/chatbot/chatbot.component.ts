// src/app/chatbot/chatbot.component.ts

import { Component } from '@angular/core';

interface CustomWindow extends Window {
  embeddedChatbotConfig?: {
    chatbotId: string;
    domain: string;
  };
}

@Component({
  selector: 'app-chatbot',
  templateUrl: './chatbot.component.html',
  styleUrls: ['./chatbot.component.scss'],
})
export class ChatbotComponent {
  constructor() {
    const customWindow: CustomWindow = window;

    customWindow.embeddedChatbotConfig = {
      chatbotId: 'Cc_MG3dQedN2zrgpkh9kL',
      domain: 'www.chatbase.co',
    };

    const script = document.createElement('script');
    script.src = 'https://www.chatbase.co/embed.min.js';
    script.setAttribute('chatbotId', 'Cc_MG3dQedN2zrgpkh9kL');
    script.setAttribute('domain', 'www.chatbase.co');
    script.defer = true;

    script.onload = () => {
      console.log('Chatbase script loaded successfully!');
      // Perform additional actions if needed
    };

    script.onerror = (error) => {
      console.error('Error loading Chatbase script:', error);
    };

    document.head.appendChild(script);
  }
}
