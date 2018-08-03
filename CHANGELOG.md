# Changelog - see https://keepachangelog.com for conventions

## [Unreleased]

### Added

### Changed

### Deprecated

### Removed

### Fixed

## [1.0.2] - 2018-08-02

### Fixed
- re-adding javax.el dependency in main code, as it's required by application using internal-api - this way they don't need to import it themselves. 
- setting javax.el to 3.0.0 to avoid confusion 

## [1.0.1] - 2018-07-11

### Added
- adding a new constructor signature on IssueProvidingContentException, to pass the original exception
- we can now make Maven releases through Travis 

### Removed
- getType method in ActionToReplicate interface, as it's not required (we'll use the fully qualified class name now)

## [1.0.0] - 2018-06-19

first version !

