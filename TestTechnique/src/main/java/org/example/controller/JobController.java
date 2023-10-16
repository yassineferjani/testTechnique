package org.example.controller;

import org.example.dto.JobDTO;
import org.example.service.IJob;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/job")
@CrossOrigin
public class JobController {
    private final IJob job;

    public JobController(final IJob job) {
        this.job = job;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<JobDTO> findAll(){
        return job.findAll();
    }

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public JobDTO findById(@PathVariable final UUID uuid){
        return job.findById(uuid).orElseThrow(() -> new RuntimeException("not exist"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobDTO save(@RequestBody final JobDTO dto){
        return job.save(dto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public JobDTO update(@RequestBody final JobDTO dto){
        return job.update(dto);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable final UUID uuid){
        job.deleteById(uuid);
    }
}
