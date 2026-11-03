# Change log

## Starter 2026-09-15
Supplied infrastructure and unfinished exercise boundary.

## Student changes
Record D1 implementation, D1 feedback fixes, D2 additions and D3 changes here.
D1:
1. Implemented Booking, Space and Proposal domain classes.
2. Added DomainRules for identifier and booking duration validation.
3. Implemented StudentApplication.propose(targetId) to validate requests and create pending proposals.
4. Added ProposalView (toView()) to return proposal details.
5. Used fixture data for booking B1 and parking spaces.
6. Tested valid and invalid durations, invalid identifiers, occupied and unknown parking spaces, pending proposal creation and unchanged booking state.
