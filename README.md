# 💱 Challenge 2 - Conversor de Moedas

Este projeto é o segundo desafio do programa **Oracle Next Education (ONE)** em parceria com a **Alura**. O objetivo foi desenvolver um **conversor de moedas** utilizando **Java 21**, consumindo dados em tempo real de uma API externa.

## ⚙️ Tecnologias e Ferramentas

- ✅ **Java 21**
- 🌐 [**Exchange Rate API**](https://www.exchangerate-api.com/) – para obter as taxas de câmbio atualizadas
- 📦 **Gson** – para fazer o parse dos dados JSON da API

## 🎯 Objetivo

Construir uma aplicação de linha de comando que permita ao usuário converter valores entre diferentes moedas, utilizando dados atualizados da internet. O projeto reforça conceitos como:

- Requisições HTTP em Java
- Manipulação de JSON com Gson
- Boas práticas de estruturação e organização de código
- Programação orientada a objetos (POO)

## 🧠 O que você vai encontrar no projeto

- Conversão entre várias moedas (USD, BRL, EUR, ARS, etc.)
- Interface simples no terminal para interação com o usuário
- Consumo de API REST com tratamento de erros
- Conversão precisa e baseada em valores atualizados

---

## ▹ Como executar

1. Clone o repositório:
   
   ```bash
   git clone https://github.com/Grazixz/conversor--de--moedas--challenge2--one

## ⚠️Antes de executar: 
- Precisa modificar a classe **ExchangenerateApi**, pegue uma key no [**site da API**](https://www.exchangerate-api.com/) e altera o atributo **key** da classe;
- Precisa implementar a dependência do gson, que está na pasta **dependences**;

