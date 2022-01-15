package com.cidoliveiraa.simianapi.usecase;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cidoliveiraa.simianapi.domain.entity.DNA;
import com.cidoliveiraa.simianapi.domain.exception.InvalidDNAException;
import com.cidoliveiraa.simianapi.usecase.port.DNARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimianVerify {
  @Autowired
  private DNARepository dnaRepository;

  public boolean verify(DNA dna) throws InvalidDNAException {
    dna.validateSequence();

    DNA dnaData = dnaRepository.findBySequence(dna.getSequence());
    if (!dnaData.isEmpty())
      return dnaData.isSimian();

    dna.setSimian(isSimian(dna.getSequence()));
    dnaRepository.save(dna);

    return dna.isSimian();
  }

  private boolean isSimian(List<String> sequence) {
    int sequenceCount = 0;
    for (int verificationLevel = 1; verificationLevel <= 4; verificationLevel++) {
      sequenceCount += simianDNAMatrixVerification(sequence, verificationLevel);
      if (sequenceCount > 1)
        return true;
    }
    return false;
  }

  private int simianDNAMatrixVerification(List<String> sequence, int level) {
    switch (level) {
      case 1:
        return countSequencesHorizontally(sequence);
      case 2:
        return countSequencesVertically(sequence);
      case 3:
        return countSequencesDiagonallyFromLeft(sequence);
      case 4:
        return countSequencesDiagonallyFromRight(sequence);
      default:
        return 0;
    }
  }

  private int countSequencesHorizontally(List<String> sequence) {
    int sequenceCount = 0;
    for (String line : sequence) {
      Pattern pattern = Pattern.compile("AAAA|TTTT|CCCC|GGGG");
      Matcher matcher = pattern.matcher(line);

      while (matcher.find())
        sequenceCount++;

      if (sequenceCount > 1)
        return sequenceCount;
    }
    return sequenceCount;
  }

  private int countSequencesVertically(List<String> sequence) {
    int sequenceCount = 0;
    int charCount = 0;

    for (int column = 0; column < sequence.size(); column++) {
      for (int line = 0; line < sequence.size(); line++) {
        if (line == sequence.size() - 1)
          break;

        char actualValue = sequence.get(line).charAt(column);
        char nextValue = sequence.get(line + 1).charAt(column);
        if (actualValue == nextValue) {
          if (charCount == 0) {
            charCount = 2;
          } else {
            charCount++;
          }
        } else {
          charCount = 0;
        }

        if (charCount > 3) {
          sequenceCount++;
          charCount = 0;
        }

        if (sequenceCount > 1)
          return sequenceCount;
      }
    }
    return sequenceCount;
  }

  private int countSequencesDiagonallyFromLeft(List<String> sequence) {
    int sequenceCount = 0;

    for (int i = 1; i < sequence.size() - 3; i++) {
      sequenceCount += countSequencesLineDiagonallyFromLeft(sequence, i, 0);
      if (sequenceCount > 1)
        return sequenceCount;
    }

    for (int j = 0; j < sequence.size() - 3; j++) {
      sequenceCount += countSequencesLineDiagonallyFromLeft(sequence, 0, j);
      if (sequenceCount > 1)
        return sequenceCount;
    }

    return sequenceCount;
  }

  private int countSequencesLineDiagonallyFromLeft(List<String> sequence, int startFromLine, int startFromColumn) {
    int sequenceCount = 0;
    int charCount = 0;
    int column = startFromColumn;

    for (int line = startFromLine; line < sequence.size(); line++) {
      if (line == sequence.size() - 1 || column == sequence.size() - 1)
        break;

      char actualValue = sequence.get(line).charAt(column);
      char nextValue = sequence.get(line + 1).charAt(column + 1);
      if (actualValue == nextValue) {
        if (charCount == 0) {
          charCount = 2;
        } else {
          charCount++;
        }
      } else {
        charCount = 0;
      }

      if (charCount > 3) {
        sequenceCount++;
        charCount = 0;
      }

      if (sequenceCount > 1)
        return sequenceCount;

      column++;
    }
    return sequenceCount;
  }

  private int countSequencesDiagonallyFromRight(List<String> sequence) {
    int sequenceCount = 0;

    for (int i = 1; i < sequence.size() - 3; i++) {
      sequenceCount += countSequencesLineDiagonallyFromRight(sequence, i, sequence.size() - 1);
      if (sequenceCount > 1)
        return sequenceCount;
    }

    for (int j = 1; j <= sequence.size() - 3; j++) {
      sequenceCount += countSequencesLineDiagonallyFromRight(sequence, 0, sequence.size() - j);
      if (sequenceCount > 1)
        return sequenceCount;
    }

    return sequenceCount;
  }

  private int countSequencesLineDiagonallyFromRight(List<String> sequence, int startFromLine, int startFromColumn) {
    int sequenceCount = 0;
    int charCount = 0;
    int column = startFromColumn;
    for (int line = startFromLine; line < sequence.size(); line++) {
      if (line == sequence.size() - 1 || column == 0)
        break;

      char actualValue = sequence.get(line).charAt(column);
      char nextValue = sequence.get(line + 1).charAt(column - 1);
      if (actualValue == nextValue) {
        if (charCount == 0) {
          charCount = 2;
        } else {
          charCount++;
        }
      } else {
        charCount = 0;
      }

      if (charCount > 3) {
        sequenceCount++;
        charCount = 0;
      }

      if (sequenceCount > 1)
        return sequenceCount;

      column--;
    }

    return sequenceCount;
  }
}
