
def permutate(prefix, input):
    output = []

    if len(input) == 0:
        return [''.join(prefix)]

    for letter in input:
        next_input = list(filter(lambda x: x != letter, input))
        output += permutate(prefix + [letter], next_input)

    return output

output = permutate([], ['1', '2', '3', '4'])
print(output)