package com.milos.fleetapp.services;

import com.milos.fleetapp.models.State;
import com.milos.fleetapp.repositories.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    //get list of states
    public List<State> getStates() {
         return stateRepository.findAll();
    }
    //save new state
    public void save(State state) {
        stateRepository.save(state);
    }
    //return state by id
    public Optional<State> findById(int id) {
        return stateRepository.findById(id);
    }
    //delete state by id
    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
