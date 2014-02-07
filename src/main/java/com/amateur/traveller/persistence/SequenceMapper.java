package com.amateur.traveller.persistence;

import com.amateur.traveller.domain.Sequence;

public interface SequenceMapper {

  Sequence getSequence(String name);
  void updateSequence(Sequence sequence);
  int insertSequence(Sequence sequence);
}