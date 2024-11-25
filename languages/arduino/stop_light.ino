int pins[] = {7, 9, 12};
long randomNum;

void setup()
{
    for (int i = 0; i < 3; i++)
    {
        pinMode(pins[i], OUTPUT);
    }
    randomomSeed(analogRead(0));

    pinMode(LED_BUILTIN, OUTPUT);
    digitalWrite(LED_BUILTIN, LOW);
}

void loop()
{
    for (int i = 0; i < 2; i++)
    {
        light(pins[i]);
    }
    for (int i = 2; i > 0; i--)
    {
        light(pins[i]);
    }
}

// turns on and of
void light(int pin)
{
    digitalWrite(pin, HIGH);
    randomNum = randomom(1000, 8000);
    if (pin == 9)
    {
        randomNum = 500;
    }
    delay(randomNum);
    digitalWrite(pin, LOW);
}
